# React Native Chartbeat SDK

The React Native Chartbeat SDK is a native library providing Chartbeat tracking functionality for Android and iOS apps.

## Installation

```sh
yarn add react-native-chartbeat-sdk
```

or if you're using __npm__

```sh
npm install react-native-chartbeat-sdk --save
```

## Usage

```js
import Chartbeat from "react-native-chartbeat-sdk";

function setupTracker(accountId: string, domain: string) {
  Chartbeat.setupTracker(accountId, domain);
}

function trackView(viewId: string, viewTitle: string) {
  Chartbeat.trackView(viewId, viewTitle);
}

function setSections(sections: Array<string>) {
  Chartbeat.setSections(sections);
}

function setAuthors(authors: Array<string>) {
  Chartbeat.setAuthors(authors);
}

function setUserAnonymous() {
  Chartbeat.setUserAnonymous();
}

function setUserLoggedIn() {
  Chartbeat.setUserLoggedIn(authors);
}

function setUserPaid() {
  Chartbeat.setUserPaid();
}

function stopTracker() {
  Chartbeat.stopTracker();
}
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

### Follow me on Twitter: [@shukerullah](https://twitter.com/shukerullah)

<a href="https://www.buymeacoffee.com/shukerullah" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: 41px !important;width: 174px !important;box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;-webkit-box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;" ></a>
