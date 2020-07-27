# Spring Redis Example

Download and install the Redis.

* [Windows](https://github.com/rgl/redis/downloads)
* [Linux](https://redis.io/download)

Once installed, make sure Redis server runs at the port 6379. If your downloaded version is a zipped one, you have to run the bat/sh file manually.

If needed, run redis-cli to access it directly.

If you run in another port other than 6379/installed Redis in a remote server, update the path in the [property](./src/main/resources/application.properties) file.

Once you update the property, run the project. 

I have attached the postman collection under [resources](./src/main/resources) package.
