package com.example.padc_themovieapp_tutorial_tyno.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.activities.VideoPlayerActivity
import com.example.padc_themovieapp_tutorial_tyno.utiils.IMAGE_URL
import kotlinx.android.synthetic.main.fragment_image_slider.*

class ImageSliderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_slider,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString(IMAGE_URL_KEY)
        val movieId = arguments?.getInt(ID_KEY)
        Glide.with(view.context)
            .load(IMAGE_URL + "original" +url)
            .into(ivSliderImage)

        ivSliderImage.setOnClickListener {
            startActivity(VideoPlayerActivity.newIntent(context!!, movieId!!))
        }
    }

    companion object {
        private const val IMAGE_URL_KEY = "imageUrlKey"

        const val ID_KEY = "ID_KEY"

        fun newInstance(url : String, id : Int) : ImageSliderFragment {
            val fragment = ImageSliderFragment()
            val bundle = Bundle()
            bundle.putString(IMAGE_URL_KEY, url)
            bundle.putInt(ID_KEY,id)
            fragment.arguments = bundle
            return fragment
        }
    }
}