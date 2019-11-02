package penseur.bases

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.lang.NullPointerException

interface FAInterface : TagInterface {

    val containerId: Int
    val context: Context
    val tagStack: ArrayList<String>
    val map: HashMap<String, BaseFragment>
    val activity: AppCompatActivity

    var fragment: Fragment
    fun openFragment(tag: String) {

        Log.d(TAG, tag)
        try {
            fragment = map.get(tag)!!

            activity.supportFragmentManager.beginTransaction().replace(containerId, fragment, tag).commit()
            if (tagStack.size == 0 || tagStack[tagStack.lastIndex] != tag) {
                tagStack.add(tag)
            }
        } catch (e: NullPointerException) {

            Log.d(TAG, e.message.toString())
            e.printStackTrace()
        }
    }

    fun clickActivityView(viewId: Int) {}

    fun gotoPrevFragment(): Boolean {
        Log.d(TAG, "gotoPrevFragment")
        if (tagStack.size > 1) {
            tagStack.remove(tagStack.last())
            openFragment(tagStack.last())
            return true
        }
        return false
    }

}