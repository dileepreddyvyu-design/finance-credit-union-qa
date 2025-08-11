pipeline {
  agent any
  stages {
    stage('UI Tests') {
      steps {
        dir('ui-tests') {
          sh 'mvn -q test -DsuiteXmlFile=src/test/resources/testng.xml'
        }
      }
      post {
        always { junit 'ui-tests/target/surefire-reports/*.xml' }
      }
    }
    stage('API Tests') {
      steps {
        dir('api-tests/postman') {
          sh 'newman run finance-credit-union.postman_collection.json -e environments/local.postman_environment.json --reporters cli,html --reporter-html-export newman-report.html'
        }
      }
    }
  }
}
