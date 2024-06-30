//Jenkins DSL Config:
pipelineJob('k8s-frontend-backend-app-deploy-pipeline') {
    description('Pipeline to deploy Kubernetes YAML files from k8s_frontend_backend_app repository')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        //url 'https://your-git-repository-url/sample10.git'
                        url 'https://github.com/Unnikrishnan-K-M/k8s_frontend_backend_app.git'
                        //credentials('your-git-credentials-id') // Replace with your Jenkins credentials ID for Git
                        credentials('git-access-on-Jenkins-token') // Replace with your Jenkins credentials ID for Git 
                    }
                    branch 'main' // Replace with your branch name
                }
            }
            scriptPath('Jenkinsfile') // Path to the Jenkinsfile in the repository
        }
    }
    triggers {
        scm('H/5 * * * *') // Poll SCM for changes every 5 minutes (adjust as needed)
    }
}