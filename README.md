#Floaty Field

Floaty Field is a JavaFX port of the [JVFloatLabeledTextField](https://github.com/jverdi/JVFloatLabeledTextField) project.

![you cannot see the beautiful screen shot](doc/floaty-field.png)

Credits for the concept to Matt D. Smith, and his [original design](http://dribbble.com/shots/1254439--GIF-Mobile-Form-Interaction?list=users):

![Matt D. Smith's Design](http://dribbble.s3.amazonaws.com/users/6410/screenshots/1254439/form-animation-_gif_.gif)

Say Hi [@andy_till](https://twitter.com/andy_till) or check it out on [youtube](http://www.youtube.com/watch?v=R432dKBK2aU&feature=youtu.be)

### Compiling

From the project directory, run the following command to compile and install locally.

    mvn clean install install:install-file -Dfile=target/floaty-field-1.0.1.jar -DgroupId=andytill -DartifactId=floaty-field -Dversion=1.0.1 -Dpackaging=jar

Now you can add floaty-field to your pom.xml dependencies:

    <dependency>
      <groupId>andytill</groupId>
      <artifactId>floaty-field</artifactId>
      <version>1.0.1</version>
    </dependency>

