package com.bast.weatherapp.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.bast.weatherapp.R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        viewModel.forecast().observe( this , Observer{
            progress.visibility = View.GONE
            chart.visibility = View.VISIBLE

            if( it != null ) {
                val entries: List<Entry> = it.list.map{
                        item -> Entry( item.dateTime?.toFloat()!!, item.main?.humidity?.toFloat()!! ) }

                val lineDataSet = LineDataSet( entries, "humidity" )

                lineDataSet.lineWidth = 1.75f
                lineDataSet.circleRadius = 5f
                lineDataSet.circleHoleRadius = 2.5f
                lineDataSet.setCircleColor(Color.GREEN)
                lineDataSet.highLightColor = Color.MAGENTA
                lineDataSet.setDrawValues(false)
                lineDataSet.fillColor = Color.MAGENTA
                lineDataSet.fillAlpha = 110

                chart.data = LineData( lineDataSet )
                chart.description.isEnabled = false
                chart.setTouchEnabled( false )
                chart.notifyDataSetChanged()
                chart.invalidate()
            } else {
                chart.data = null
            }
        } )

        city_name_button.setOnClickListener {
            val cityName = city_name.text?.toString()

            if ( !TextUtils.isEmpty( cityName ) ) {
                progress.visibility = View.VISIBLE
                chart.visibility = View.GONE

                viewModel.request( ForecastRequestDataItem( type = RequestType.CITY_NAME_SEARCH, name = cityName ) )
                city_name.text.clear()
                hideKeyboard()
            }
        }

        lat_lon_button.setOnClickListener {
            val latitude = lat.text?.trim().toString()
            val longitude = lon.text?.trim().toString()

            try {
                if ( !TextUtils.isEmpty( latitude ) && !TextUtils.isEmpty( longitude ) ) {
                    progress.visibility = View.VISIBLE
                    chart.visibility = View.GONE

                    viewModel.request( ForecastRequestDataItem( type = RequestType.LAT_LON_SEARCH, lat = latitude.toDouble(), lon = longitude.toDouble() ) )
                    lat.text.clear()
                    lon.text.clear()
                    hideKeyboard()
                }
            } catch (e: Exception) {
                Timber.d( e )
            }
        }

        zip_button.setOnClickListener {
            val zipCode = zip.text?.toString()

            if ( !TextUtils.isEmpty( zipCode ) ) {
                progress.visibility = View.VISIBLE
                chart.visibility = View.GONE

                viewModel.request( ForecastRequestDataItem( type = RequestType.ZIP_SEARCH, name = zipCode ) )
                zip.text.clear()
                hideKeyboard()
            }
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow( city_name.windowToken, 0 )
    }
}
