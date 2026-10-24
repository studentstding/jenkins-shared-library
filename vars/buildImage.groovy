def call(String imageName, String imageTag) {

    container('kaniko', {

        sh """
        /kaniko/executor \
          --context=${WORKSPACE}/ \
          --dockerfile=${WORKSPACE}/demo/demo/Dockerfile \
          --destination=${imageName}:${imageTag}
        """

    })
}
