package com.rohan.drawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private var drawingView:DrawingView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawing_view)
        drawingView?.setSizeForBrush(20.toFloat())

        val ib_brush : ImageButton = findViewById(R.id.ib_brush)

        ib_brush.setOnClickListener {
            showBrushSizeChooserDialog()
        }

    }

    private fun showBrushSizeChooserDialog(){
        var brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialogue_brush_size)
        brushDialog.setTitle("Brush size:")
        val smallbtn:ImageButton = brushDialog.findViewById(R.id.ib_small_brush)
        smallbtn.setOnClickListener(View.OnClickListener {
            drawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        })
        val mediumbtn:ImageButton = brushDialog.findViewById(R.id.ib_medium_brush)
        mediumbtn.setOnClickListener({
            drawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        })
        val largebtn:ImageButton = brushDialog.findViewById(R.id.ib_large_brush)
        largebtn.setOnClickListener({
            drawingView?.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        })
        brushDialog.show()

    }
}