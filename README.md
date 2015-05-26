# oppna-program-reklistan-skinny-json

This is a a "manual" fork of [liferay-plugins](https://github.com/liferay/liferay-plugins) with everything but skinny-json stripped out. 

The skinny-json service is modified to work with repeatable and nested journal article fields. This is sent as a PR to Liferay but not yet merged. However, even when merged we need to hold our own fork as we need to be able to grab not yet published journal articles without special permissions.

This service is used to get all REK data as JSON. It's also used to being able to display the custom preview/diff templates.

## Build

```
cd liferay-plugins/webs/skinny-web
ant
```
