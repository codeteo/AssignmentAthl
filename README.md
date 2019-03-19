# Movies Sample App

Simple example creating an Android application using the API provided by 
(The Movie DB)[https://www.themoviedb.org/documentation/api].

## Features

* Search for movies and tv shows
* Select a movie or show and view further details like the genre

## How to build this project

This app uses [The Movie Database](https://www.themoviedb.org/documentation/api) API to retrieve movies.
You must provide your own API key in order to build the app. Create a file named `serets.properties` in the 
app's top folder (`/AssignmentAthl/`) and paste your API key like : 
    ```
    API_KEY=*******************
    ```

## Libraries

* [Dagger 2](https://google.github.io/dagger/)
* [Retrofit 2](https://square.github.io/retrofit/)
* [RxJava 2](https://github.com/ReactiveX/RxJava)
* [RxAndroid 2](https://github.com/ReactiveX/RxAndroid)
* [Otto](https://github.com/square/otto)
* [Picasso](https://square.github.io/picasso/)
* A lot of the most common Google libraries like: RecyclerView, CardView, Design Support, etc. 

## Architecture

The app follows the famous `Clean Architecture` developed by [Robert C. Martin](http://blog.cleancoder.com/) which
is based on spliting your codebase in separate layers. This way you have a more scalable codebase which is easy to
scale, test and you can keep it free from hard dependencies to frameworks. On top of this architecture the app also
features the `MVP` pattern by using a `Presentation` layer as a middleman between the `Android` framework and 
the `Domain` layer. 

You can have a high level overview of the architecture in the following image: 


![](./art/architecture-layers.png)

There are three main layers : Presentation, Domain and Data. The first layer is the outer layer in the image 
above and it is responsible to anything related to display data on the screen and handle the interactions of
the user. The second layer is the Domain which contains all the bussiness logic of the app. It also contains 
the entities that are useful for our app, things like a Movie or a Show entity belong to this layer. The last
layer is the one named Data. It interacts with all different kinds of data sources to get the data the app needs
to display. 

Each outer layer has a dependency to the one layer that is inner of it. More pricesely it has a dependency to
an abstraction of the inner layer. This is a principle that is called `Inversion of Control` and it is critical for the success of this architecture.
In short what this principle says is that high-modules should not depend on lower modules and all the communication
should happen through abstractions (Interfaces). This way we can have a clean separation of the layers and clear
boundaries between the components of our code.
Thanks to separation of concerns between classes we can easily change an application code and add new functional with modifying minimal number of classes. 

### Further reading 

* [Uncle Bob - The Clean Architecture](https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html)
* [Fernando Cejas - Architecting Android Reloaded](https://fernandocejas.com/2018/05/07/architecting-android-reloaded/)
* [Antonio Leiva - Clean Architecture for Andorid with Kotlin](https://antonioleiva.com/clean-architecture-android/)

## License

```
    Copyright 2019 Theo Ioakeimidis
	
	Licensed to the Apache Software Foundation (ASF) under one or more contributor
	license agreements. See the NOTICE file distributed with this work for
	additional information regarding copyright ownership. The ASF licenses this
	file to you under the Apache License, Version 2.0 (the "License"); you may not
	use this file except in compliance with the License. You may obtain a copy of
	the License at

	   http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
	License for the specific language governing permissions and limitations under
	the License.
``````