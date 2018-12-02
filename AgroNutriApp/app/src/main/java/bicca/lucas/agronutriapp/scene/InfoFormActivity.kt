package bicca.lucas.agronutriapp.scene

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.databinding.ActivityInfoFormBinding

class InfoFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_info_form)
    }
}
