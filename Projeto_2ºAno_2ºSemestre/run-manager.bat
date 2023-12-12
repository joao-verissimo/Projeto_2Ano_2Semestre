REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.app.manager\target\base.app.manager-1.4.0-SNAPSHOT.jar;base.app.manager\target\dependency\*;

REM call the java VM, e.g, 
java -cp %BASE_CP% eapli.base.app.manager.ManagerApp
