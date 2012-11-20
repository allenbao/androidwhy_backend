  androidwhy_backend project is a java backend project.

  It has 4 major modules:
  1.backend-parent;
  2.backend-core;
  3.backend-extension;
  4.backend-test;
  
  And 4 major examples:
  1.basicservice;
  2.basicweb;
  3.helloworld;
  4.showcase.

  -------------------------------------------------
  Get start:

  1,
  git clone https://github.com/gordonhuang/androidwhy_backend.git

  2,
  cd androidwhy_backend/modules

  3,
  mvn install -Dmaven.test.skip=true

  -------------------------------------------------
  Get start from example project:

  1,
  mvn archetype:create-from-project

  2,
  cd target/generated-sources/archetype
  mvn install

  3,
  mvn archetype:generate -DarchetypeCatalog=local
 
  -------------------------------------------------
  欢迎访问：http://www.androidwhy.com



