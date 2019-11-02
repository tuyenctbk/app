package penseur.bases

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.localbroadcastmanager.content.LocalBroadcastManager

interface LocalMessageInterface : TagInterface {

    val localBroadcastReceiver: BroadcastReceiver
    val lbm
        get() = LocalBroadcastManager.getInstance(this as Context)

    fun registerLocalMessageReceiver() {
        lbm.registerReceiver(localBroadcastReceiver, IntentFilter(TAG))
    }

    fun unregisterLocalMessageReceiver() {
        lbm.unregisterReceiver(localBroadcastReceiver)
    }


    fun sendLocalMsg(msgTo: String, params: ArrayList<Pair<String, String>>) {
        val intent = Intent(msgTo)

        for (param in params) {
            intent.putExtra(param.first, param.second)
        }

        lbm.sendBroadcast(intent)
    }


}

