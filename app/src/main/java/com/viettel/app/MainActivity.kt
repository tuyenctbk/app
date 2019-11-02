package com.viettel.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import penseur.bases.*

class MainActivity : BaseActivity(), FAInterface, LocalMessageInterface, NetworkStatusInterface {

    override val containerId: Int = R.id.flFragmentContainer
    override val context: Context = this
    override val tagStack: ArrayList<String> = ArrayList()
    override val map: HashMap<String, BaseFragment> = HashMap()
    override val activity: BaseActivity = this
    override var fragment: Fragment = Fragment()
    override val localBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
    override val networkStatusReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun onNetworkStatusChanged() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val neededPermissions: Array<String>
        get() = super.neededPermissions

    override fun loadUI() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
