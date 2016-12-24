# qcloud-java-client [![Apache License, Version 2.0](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)

Java based rest client for the [q-api](https://github.com/DasKeyboard/q/blob/master/q-api-doc.md)

Code example
------
```
final String clientId = "...";
final String clientSecret = "...";

QAuth qAuth = QAuth.create();

qAuth.createTokenByClientSecret(clientId, clientSecret)
        .map(token -> QApi.create(token.getAccessToken()))
        .flatMap(qApi -> qApi.createSignal(new Signal("Test", pid, "#FF0000", "KEY_A")))
        .subscribe();
```

License
-------

qcloud-java-client is licensed under the
[Apache License, Version 2.0](LICENSE).

```
Copyright 2016 Tim Hellhake

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```