package bicca.lucas.agronutriapp.scene

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.databinding.ActivityMainBinding
import bicca.lucas.agronutriapp.scene.info_form.InfoFormActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.goToInfoForm.setOnClickListener {
            startActivity(Intent(this, InfoFormActivity::class.java))
        }
    }
}
