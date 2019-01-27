import * as express from 'express';
import helloRoute from '../routes/hello.route';

const router = express.Router();

router.use('/hello', helloRoute);

export default router;