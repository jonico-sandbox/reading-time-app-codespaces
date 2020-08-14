## About
The [reading-time-app](https://reading-time-app.herokuapp.com/) is a web application using Java and [Maven](https://maven.apache.org/). It lists the top choices of recommended books for Hyrule.

![image](https://octodemo.com/storage/user/306/files/00da78be-15d2-11e6-83e7-63b7c037e7a2)

The application is loosely based on the Heroku tutorial [Create a Java Web Application Using Embedded Tomcat](https://devcenter.heroku.com/articles/create-a-java-web-application-using-embedded-tomcat). It uses an embedded Tomcat servlet container.

## Prerequisites
- Install [IntelliJ](https://www.jetbrains.com/idea/) (optional)
- Create a Heroku account
- Install [Heroku Toolbelt CLI](https://toolbelt.heroku.com/)
- Make sure you have Maven installed:
```
mvn -version
```

Java and Maven 3 should be installed by default on Mac OSX.

Using IntelliJ is optional, you can use any editor like Eclipse or Atom or edit directly on GitHub.
Command line would work to :stuck_out_tongue:

## Configuration
This configuration assumes you are using `octodemo.com`.
- Fork and clone the  `reading-time-app` repository.
- Create the Heroku app, execute an initial deploy and open the web application:
```
heroku create
git push heroku master
heroku open
```
- Remember the name of the application. You can also provide one using:
```
heroku create reading-time-app
```
- Create a token for deployment integration:
```
heroku plugins:install https://github.com/heroku/heroku-oauth
heroku authorizations:create --description "For use with octodemo.com"
```
- Add *Travis CI* service hook for end-point `https://travis.octodemo.com/listener`
- Add *GitHub Auto-Deployment* hook for end-point `https://octodemo.com/api/v3` with GitHub token scope `repo` with `continuous-integration/travis-ci` as status context
- Add *HerokuBeta* service hook for end-point `https://octodemo.com/api/v3` with GitHub token scope `repo-deployment`, the created Heroku token and the name of the Heroku application

The deployments integration follows the steps described in [Automating deployments to integrators](https://developer.github.com/guides/automating-deployments-to-integrators/).

## Installing and running on a local machine
To install and run the `reading-time-app` application on your local machine execute the following commands:
```
mvn clean install
sh target/bin/webapp
open http://localhost:8080
```
To skip the tests:
```
mvn -B -DskipTests=true clean install
```
To run the unit tests execute the following command:
```
mvn clean test
```
To create and view the `reading-time-app` reports:
```
mvn site
open target/site/index.html
```

## Heroku configuration
The Heroku configuration is in [Procfile](Procfile). It specifies the process to run after a deployment:
```
web: sh target/bin/webapp
```

## Review Ninja
https://office-tools-reviewninja.herokuapp.com/

## Contributing for beginners
First of all, welcome to the team :sparkles: :tada: :heart:!

We have an issue label called [`beginners`](https://github.com/jonico-sandbox/reading-time-app-codespaces/labels/beginners) for issues that should be perfect to get going, [check them out](https://github.com/jonico/reading-time-app/labels/beginners), assign yourself and :ship: your first code. 
