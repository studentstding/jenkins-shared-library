def call(String imageName, String imageTag) {
    container('kaniko') {
        withCredentials([
            file(
                credentialsId: 'gcp-sa-key',
                variable: 'GCP_KEY_FILE'
            )
        ]) {
            sh """
                set -eu

                cp "\${GCP_KEY_FILE}" /kaniko/gcp-key.json
                export GOOGLE_APPLICATION_CREDENTIALS=/kaniko/gcp-key.json

                /kaniko/executor \
                    --context="\${WORKSPACE}" \
                    --dockerfile="\${WORKSPACE}/Dockerfile" \
                    --destination="${imageName}:${imageTag}"
            """
        }
    }
}
