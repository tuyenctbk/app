package penseur.bases

interface TagInterface {

    val TAG: String
        get() {
            return javaClass.simpleName
        }
}


