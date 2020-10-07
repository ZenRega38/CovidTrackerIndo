package com.regadeveloper.covidtrackerindo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.regadeveloper.covidtrackerindo.R
import com.regadeveloper.covidtrackerindo.model.DataItem
import kotlinx.android.synthetic.main.list_province.view.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class AdapterProvince(private val province: ArrayList<DataItem>, private val clickListener: (DataItem) -> Unit) :
    RecyclerView.Adapter<ProvinceViewHolder>(), Filterable {

    var provincefirstlist = ArrayList<DataItem>()
    init {
        provincefirstlist = province
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_province, parent, false)
        return ProvinceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return provincefirstlist.size
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(provincefirstlist[position], clickListener)
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val  charSearch = constraint.toString()
                provincefirstlist = if (charSearch.isEmpty()){
                    province
                } else {
                    val resultList = ArrayList<DataItem>()
                    for (row in province){
                        val search = row.provinsi?.toLowerCase(Locale.ROOT) ?: ""
                        if (search.contains(charSearch.toLowerCase(Locale.ROOT))){
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResult = FilterResults()
                filterResult.values = provincefirstlist
                return filterResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                provincefirstlist = results?.values as  ArrayList<DataItem>
                notifyDataSetChanged()
            }
        }
    }
}
class ProvinceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    fun bind(aprovinsi : DataItem, clickListener: (DataItem) -> Unit){
        val province : TextView = itemView.tv_provinceName
        val province_totalCases : TextView = itemView.tv_provinceTotalCases
        val province_totalRecovered : TextView = itemView.tv_provinceTotalRecovered
        val province_totalDeaths : TextView = itemView.tv_provinceTotalDeaths

        val formatter: NumberFormat = DecimalFormat("#,###")

        province.tv_provinceName.tv_provinceName.text = aprovinsi.provinsi
        province_totalCases.tv_provinceTotalCases.text = formatter.format(aprovinsi.kasusPosi?.toDouble())
        province_totalRecovered.tv_provinceTotalRecovered.text = formatter.format(aprovinsi.kasusSemb?.toDouble())
        province_totalDeaths.tv_provinceTotalDeaths.text = formatter.format(aprovinsi.kasusMeni?.toDouble())
    }
}