def call(String imageName, String imageTag) {

    container('kaniko', {

        sh """
        /kaniko/executor \
          --context=${WORKSPACE}/demo/demo \
          --dockerfile=${WORKSPACE}/demo/demo/Dockerfile \
          --destination=${imageName}:${imageTag}
        """

    })
}
