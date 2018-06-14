package tw.com.sportbud.sportbud

import android.content.Context
import android.graphics.Point
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.view.Display
import android.view.WindowManager



/**
 * Created by tzuhan on 2018/06/13.
 */
// references to our images
private val mThumbIds = arrayOf<Int>(
        R.drawable.pic_back, R.drawable.pic_back2,
        R.drawable.pic_back, R.drawable.pic_back2,
        R.drawable.pic_back, R.drawable.pic_back2,
        R.drawable.pic_back, R.drawable.pic_back2,
        R.drawable.pic_back, R.drawable.pic_back2,
        R.drawable.pic_back, R.drawable.pic_back2,
        R.drawable.pic_back, R.drawable.pic_back2,
        R.drawable.pic_back, R.drawable.pic_back2,
        R.drawable.pic_back, R.drawable.pic_back2)

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
            val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val size = Point()
            val display = wm.defaultDisplay
            display.getSize(size)
            val width = size.x
            val height = size.y

            if (width > 0) {
                val padding = 5
                var count = 3
                if (width > height) {
                    count = 6
                }
                var image_width = ((width - padding * 4) / count / 10 * 10).toInt()
                var image_height = image_width
                Log.d("width&height", "image_width: " + image_width + " image_height:" + image_height)
                Log.d("width&height", "width: " + width)
                imageView.layoutParams = ViewGroup.LayoutParams(image_width, image_height)
                imageView.scaleType = ImageView.ScaleType.CENTER_CROP

                //imageView.setPadding(10, 0, 10, 0)
            }
        } else {
            imageView = convertView as ImageView
        }

        imageView.setImageResource(mThumbIds[position])
        return imageView
    }
}