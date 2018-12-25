package bicca.lucas.agronutriapp.view

import android.app.Activity
import android.content.Context
import android.support.v7.widget.AppCompatRadioButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.TextView
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.logic.PlantEnum

class PlantAdapter(context: Context, val resource: Int, val items: ArrayList<PlantEnum>) : ArrayAdapter<PlantEnum>(context, resource, items) {

    // region --- ATTRIBUTES ---
    var tempItems: ArrayList<PlantEnum> = ArrayList()
    var suggestions: ArrayList<PlantEnum> = ArrayList()
    var plantSelected: PlantEnum = PlantEnum.NONE
    // endregion

    // region --- SETUP ---
    init {
        items.forEach {
            tempItems.add(it)
        }
    }
    // endregion

    // region --- LIFECYCLE ---
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View? = convertView
        if (convertView == null) {
            val inflater: LayoutInflater = (context as Activity).layoutInflater
            view = inflater.inflate(resource, parent, false)
        }

        val plant = getItem(position)
        view?.let {
            val text: TextView = it.findViewById(R.id.item_plant_text)
            text.setText(plant.stringId)
            val radio: AppCompatRadioButton = it.findViewById(R.id.item_plant_radio)
            radio.isChecked = plant == plantSelected
        }

        return view!!
    }

    override fun getItem(position: Int): PlantEnum {
        return items[position]
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getFilter(): Filter {
        val filter = object : Filter() {

            override fun convertResultToString(resultValue: Any?): CharSequence {
                val plant = resultValue as PlantEnum
                return context.getString(plant.stringId)
            }

            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = constraint?.let {
                    suggestions.clear()
                    tempItems.forEach {
                        if (context.getString(it.stringId).toLowerCase().startsWith(constraint.toString().toLowerCase()))
                            suggestions.add(it)
                    }
                    val filterResults = FilterResults()
                    filterResults.values = suggestions
                    filterResults.count = suggestions.size
                    return filterResults
                } ?: FilterResults()
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                results?.let {
                    if (it.count > 0) {
                        val tempValues: ArrayList<PlantEnum> = it.values as ArrayList<PlantEnum>
                        clear()
                        tempValues.forEach {
                            add(it)
                            notifyDataSetChanged()
                        }
                    } else {
                        clear()
                        notifyDataSetChanged()
                    }
                }
            }
        }
        return filter
    }
    // endregion
}