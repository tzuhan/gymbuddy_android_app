package tw.com.sportbud.sportbud

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

/**
 * Created by tzuhan on 2018/06/13.
 */
// references to our images
private val mThumbIds = arrayOf<Int>(
        R.drawable.pic_back, R.drawable.pic_back,
        R.drawable.pic_back, R.drawable.pic_back,
        R.drawable.pic_back, R.drawable.pic_back,
        R.drawable.pic_back, R.drawable.pic_back,
        R.drawable.pic_back, R.drawable.pic_back,
        R.drawable.pic_back, R.drawable.pic_back,
        R.drawable.pic_back, R.drawable.pic_back,
        R.drawable.pic_back, R.drawable.pic_back,
        R.drawable.pic_back, R.drawable.pic_back)

class ImageAdapter(private val mContext: Context) : BaseAdapter() {

    override fun getCount(): Int = mThumbIds.size

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    // create a new ImageView for each item referenced by the Adapter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: ImageView
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = ImageView(mContext)
            imageView.layoutParams = ViewGroup.LayoutParams(440, 440)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            //imageView.setPadding(10, 0, 10, 0)
        } else {
            imageView = convertView as ImageView
        }

        imageView.setImageResource(mThumbIds[position])
        return imageView
    }
}