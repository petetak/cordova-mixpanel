# cordova-mixpanel

*iOS only right now. With alpha of Android version started by @petetak*

For now please note you have to change the import import com.MiDrive.MiDriveApp.R; to your own Cordova app - as the resources get compiled into the app itself and this way it can find them.  Will look for a more elegant approach later.

Cordova plugin that integrates the Native Mixpanel SDK in your cordova
application. Use it to track events, people, or revenue. You can also display
in-app notifications or surveys.

It works with cordova-3.4.0+

## Installation

1. You can install it as part of cordova hooks.

2. or just run the following in your project:

```
cordova plugin add https://github.com/poetic/cordova-mixpanel.git
```

## API

Make sure you call identify or createAlias with your mixpanel token found in your mixpanel
settings first.

```javascript

// Callbacks: s and f are success/failure callbacks respectively
// Strings: token, eventName, distinctId, alias
// JS Objects: properties
// Booleans: bool
Mixpanel.init(token, s, f)
Mixpanel.createAlias(alias, s, f)
Mixpanel.track(eventName, properties, s, f)
Mixpanel.identify(distinctId, s, f)
Mixpanel.peopleSet(properties, s, f)
Mixpanel.trackCharge(amount, s, f)
Mixpanel.trackChargeWithProperties(amount, properties, s, f)
Mixpanel.setShowNotificationOnActive(bool, s, f)
Mixpanel.showNotification(s, f)
Mixpanel.showNotificationWithID(id, s, f)
Mixpanel.setShowSurveyOnActive(bool, s, f)
Mixpanel.showSurvey(s, f)
Mixpanel.showSurveyWithID (id, s, f)

// Push Notifications
// Options: { badge: true, alert: true, sound: false}
Mixpanel.register(options, s, f)
Mixpanel.unregister(options, s, f)
Mixpanel.setApplicationIconBadgeNumber(badgeNumber, s, f)

document.addEventListener('mixpanel.push', function(event){})
```
