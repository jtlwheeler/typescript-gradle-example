# TypeScript Gradle Example
This is an example of how Gradle can be used to build multiple TypeScript applications.

The project consists of 3 sub-projects.
- client: Single-page application using [React](https://reactjs.org/).
- server: Serves the client application and API requests using [Node.js](https://nodejs.org/en/).
- e2e: End-to-end tests using [Protractor](https://www.protractortest.org/#/) and JavaScript.

To run the e2e tests, execute the command `./gradlew e2e`. This will resolve all dependencies, build the client and server apps, and run the e2e test suite. 