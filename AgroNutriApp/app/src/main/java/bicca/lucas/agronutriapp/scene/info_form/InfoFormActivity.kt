package bicca.lucas.agronutriapp.scene.info_form

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.databinding.ActivityInfoFormBinding
import bicca.lucas.agronutriapp.view.CustomPagerAdapter

class InfoFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_info_form)

        // region --- test stepper indicator ---
        val fragments = arrayOf(Fragment(), Fragment(), Fragment())
        val adpter = CustomPagerAdapter(supportFragmentManager, fragments)
        binding.activityInfoFormPager.adapter = adpter
        binding.activityInfoFormIndicator.setViewPager(binding.activityInfoFormPager)
        binding.activityInfoFormIndicator.stepCount = fragments.size
        // endregion
    }
}
