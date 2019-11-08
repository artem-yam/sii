const axios = require('axios');
const readline = require('readline');
const rl = readline.createInterface(process.stdin, process.stdout);

let BROWSERS, FEATURES, CIU_DB;


const CLASSES = [
    {
        basises: ['есть', 'использовать'],
        changes: [],
        description: 'Глаголы, инфинитив'
    },
    {
        basises: ['мо', 'использ', 'поддержива', 'смо', 'возникн', 'лома', 'получ'],
        changes: ['у', 'ем', 'ю', 'им'],
        description: 'Глаголы, первое лицо'
    },
    {
        basises: ['мо', 'использ', 'поддержива', 'смо', 'возникн', 'лома', 'получ'],
        changes: ['ут', 'ет', 'ют', 'ат'],
        description: 'Глаголы, третье лицо'
    },
    {
        basises: ['я', 'мы', 'они', 'он'],
        changes: [],
        description: 'Местоимения'
    },
    {
        basises: ['ошибк', 'поддержк', 'проблем'],
        changes: ['и', 'у', 'ок', 'а', 'е', 'ы', ''],
        description: 'Существительные, женский род'
    },
    {
        basises: ['пользовател', 'использовани', 'приложени'],
        changes: ['ю', 'ям', 'я', 'и'],
        description: 'Существительные, мужской и средний род'
    }
];

const browserLabelsSynonymous = (browserCode) => {
    switch (browserCode) {
        case 'ie':
            return ['ie', 'internet explorer', 'ms ie'];
        case 'edge':
            return ['edge', 'ms edge'];
        case 'firefox':
            return ['firefox', 'mozilla firefox', 'ff', 'fox'];
        case 'chrome':
            return ['gc', 'google chrome', 'chrome'];
        case 'opera':
            return ['opera'];
        case 'safari':
            return ['safari', 'apple safari', 'apple'];
        default:
            return [browserCode.toLowerCase()];
    }
};

const loadCIUData = async () => {
    console.log('Loading CanIUse database...');
    global.window = {};
    const {data: CIU} = await axios.get('https://caniuse.com/js-data/data.js?1570319067');
    eval(CIU);

    const dataBase = Caniuse.rawData;
    console.log('Generating browsers list...');
    const browsers = Object.keys(dataBase.agents).map(code => ({
        code,
        labels: browserLabelsSynonymous(code)
    }));
    console.log('Generating features list...');
    const features = Object.keys(dataBase.ecmascript)
        .reduce((fs, f) => fs.concat(dataBase.ecmascript[f].ids), [])
        .map(code => ({code, labels: [code.toLowerCase()]}));

    BROWSERS = browsers;
    FEATURES = features;
    CIU_DB = dataBase;
    console.log('DB successfully loaded!');
};

const pattern = (word) => {
    const browser = BROWSERS.find(({labels}) => labels.includes(word));
    if (browser) return {...browser, type: 'browser'};
    const feature = FEATURES.find(({labels}) => labels.includes(word));
    if (feature) return {...feature, type: 'feature'};

    return null;
};

const classificate = (word) => CLASSES.find(({changes, basises}) => {
    const basis = basises.find(b => word.startsWith(b));
    if (!basis) return false;

    if (!changes.length) return true;
    const change = changes.find(c => word.endsWith(c));
    if (!change) return false;

    return true;
});

const getSentenceData = (sentence) => sentence
    .toLowerCase()
    .replace(/[^a-z0-9а-я\.\ ]/g, '')
    .split(' ')
    .map(word => ({word, data: pattern(word) || classificate(word)}));

const printSentenceData = (sentence) => sentence.forEach(({word, data}) => {
    console.log(`Слово "${word}":${data ? '' : ' не значимое.'}`);
    if (!data) return;

    if (data.description) {
        console.log(`\tФлективный класс - "${data.description}".`);
        const basis = data.basises.find(b => word.startsWith(b));
        console.log(`\tОсновная часть - "${basis}".`);
        if (data.changes.length) {
            const change = data.changes.find(c => word.endsWith(c));
            const prefix = word.match(new RegExp(`${basis}(.*)${change}`))[1];
            console.log(`\tИзменяемая часть - "${prefix}${change}".`);
        }
    }
    if (data.type === 'browser') console.log(`\tЗапрос по браузеру - "${data.code}".`);
    if (data.type === 'feature') console.log(`\tЗапрос по функционалу - "${data.code}".`);
});

(async function main() {
    await loadCIUData();

    rl.setPrompt('\nВведите предложение: ');
    rl.prompt();
    rl.on('line', (line) => {
        console.log('-----');
        if (line === '/features') console.log(FEATURES.map(f => f.code));
        else if (line === '/browsers') console.log(BROWSERS.map(b => b.code));
        else if (line === 'exit') rl.close();
        else {
            const sentences = getSentenceData(line);
            if (
                !sentences.find(s => s.data && s.data.type === 'browser') ||
                !sentences.find(s => s.data && s.data.type === 'feature')
            ) {
                console.log('Переформулируйте запрос!');
            } else {
                printSentenceData(sentences);
            }
        }
        console.log('-----');
        rl.prompt();
    }).on('close', () => {
        process.exit(0);
    });
}())
