# Reddimg

Reddimg is a utility that allows you to download all the available images on a particular subreddit. 
For this it depends on the user to specify the subreddit via a JSON configuration file that needs to 
be placed in:

`<USER_HOME>/Reddimg/config.json`

The typical configuration file can look like:

```json
{
  "appId": "unique.application.id",
  "version": "version",
  "userName": "yourRedditUserName",
  "subreddit": "subRedditName"
}
```

Once the configuration file is in place we need to build the repository and build the Jar 
using following commands:

```sh
> git clone https://github.com/jeetprksh/reddimg.git
> cd reddimg
> mvn install
> java -jar target/reddimg-1.0.0.jar
```

The images would be downloaded on the directory with same name as that of subreddit on 
configuration file:

`<USER_HOME>/Reddimg/subRedditName`