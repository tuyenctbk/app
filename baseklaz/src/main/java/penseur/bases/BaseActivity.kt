package penseur.bases

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    private val REQUEST_PERMISSION_CODE: Int = 10001
    open val neededPermissions = arrayOf(Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        if (needRequestPermission()) {
            requestNeededPermission()
        } else {
            initAll()
        }
    }

    fun needRequestPermission(): Boolean {
        for (permission in neededPermissions) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED)
                return true
        }
        return false
    }

    fun requestNeededPermission() {
        requestPermissions(neededPermissions, REQUEST_PERMISSION_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (needRequestPermission()) {
                Toast.makeText(this, R.string.permission_denied, Toast.LENGTH_LONG).show()
                this.finish()
            } else {
                initAll()
            }
        }
    }

    private fun initAll() {

        loadPreferences()
        loadData()
        loadUI()
    }

    abstract fun loadUI()

    open fun loadData() {
    }

    open fun loadPreferences() {

    }
}