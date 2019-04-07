package bicca.lucas.agronutriapp.scene.result

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import bicca.lucas.agronutriapp.R

import kotlinx.android.synthetic.main.activity_view_result.*

class ViewResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_result)
        setSupportActionBar(toolbar)
        setTitle("Bazinga!")
    }

    private fun setTitle(title: String) {
        activity_view_result_title.text = title
    }

}
