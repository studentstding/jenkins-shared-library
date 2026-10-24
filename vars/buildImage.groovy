def call(String imageName, String imageTag) {

    container('kaniko', {

        sh """
        /kaniko/executor \
          --context=${WORKSPACE}/ \
          --dockerfile=${WORKSPACE}/Dockerfile \
          --destination=${imageName}:${imageTag}
        """

    })
}
