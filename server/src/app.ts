import * as express from 'express';
import * as bodyParser from 'body-parser';
import routes from './routes/index.route';
import * as cors from 'cors';
import * as path from 'path';

const app = express();

app.use(cors());
app.set('port', '3001');
app.use(bodyParser.json());
app.use('/api', routes);
app.use(express.static(path.join(__dirname, 'assets')));
app.get('/*', function (req, res) {
    res.sendFile(path.join(__dirname, 'assets', 'index.html'));
});

module.exports = app;