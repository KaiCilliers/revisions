package com.example.testzone.mars.overview.list

import com.example.testzone.generated.callback.OnClickListener
import com.example.testzone.mars.network.MarsProperty

class MarsPropertyListener (val clickListener: (marsProperty: MarsProperty) -> Unit) {
    fun onMarsClick(marsProperty: MarsProperty) = clickListener(marsProperty)
}