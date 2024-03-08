pipeline {
    agent any
    tools {
        maven "Maven 3.9.6"
    }
    parameters {
       choice(
          name: "PROJECT",
          choices: ['Smoke', 'Regression', 'TLMS', 'Project 1', 'Project 2', 'Project 3', 'Project 4'],
          description: 'Choose project'
       )
       string(
          name: "TEST_CASE_ID",
          defaultValue: "",
          description: 'Enter the ID of the test case, or TYPE: API, UI'

       )
    }
    stages {
        stage('Test') {
            steps {
                script {
                   def project = params.PROJECT ?: 'SmokeTest'
                   def testType = params.TEST_CASE_ID ?: 'UI'
                   sh "mvn clean test -P $project -Dgroups=$testType -DfailIfNoTests=false"
                }
            }
            post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '17.0.1',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
