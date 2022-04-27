package com.wemlart.janken

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class GameFragment : Fragment(), View.OnClickListener {
    var win = 0
    var lose = 0
    var comMessage: TextView? = null
    var resultMessage: TextView? = null
    var comHand: TextView? = null
    var youHand: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // button・message
        comMessage = view.findViewById(R.id.comMessage)
        resultMessage = view.findViewById(R.id.resultMessage)
        comHand = view.findViewById(R.id.comHandMessage)
        youHand = view.findViewById(R.id.youHandMessage)
        // クリックしたらonClick()へ
        view.findViewById<View>(R.id.rockButton).setOnClickListener(this)
        view.findViewById<View>(R.id.scissorButton).setOnClickListener(this)
        view.findViewById<View>(R.id.paperButton).setOnClickListener(this)
        // Fragment を使った Nav Controller の取得
        //val navController = this.findNavController()
        //val button = view.findViewById<Button>(R.id.rockButton)
        //button.setOnClickListener {
        //    navController.navigate(R.id.action_gameFragment_to_resultFragment)
        //}
    }
    override fun onClick(view: View) {
        // コンピュータのおてて乱数
        val com = (Math.random() * 3).toInt() //0=ぐー 1=ちょき 2=ぱー
        // グーチョキパーのボタン
        if(win >= 5) this.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
        if (view.id == R.id.rockButton) battle(0, com)
        else if (view.id == R.id.scissorButton) battle(1, com)
        else if (view.id == R.id.paperButton) battle(2, com)
    }
    private fun battle(you: Int, com: Int) {
        comMessage!!.text = "じゃーんけーん…"
        comMessage!!.text = "ぽん！"
        // 自分のおてて
        if (you == 0) youHand!!.text = "✊"
        else if (you == 1) youHand!!.text = "✌"
        else youHand!!.text = "✋"
        // コンピュータのおてて
        if (com == 0) comHand!!.text = "✊"
        else if (com == 1) comHand!!.text = "✌"
        else comHand!!.text = "✋"
        // 勝敗判定
        if (you == com) {   //あいこ
            comMessage!!.text = "なかなかやるじゃない"
        } else if (you - com == -1 || you - com == 2) {    //勝ち
            win++
            comMessage!!.text = "くっ、この私が…"
        } else {   //you-com==-2||you-com==1   //負け
            lose++
            comMessage!!.text = "ま、当然の結果ね！"
        }
        resultMessage!!.text = win.toString() + "勝" + lose + "敗"
    }
}

/*
class MainActivity_old : AppCompatActivity(), View.OnClickListener {

    var win = 0
    var lose = 0
    var comMessage: TextView? = null
    var resultMessage: TextView? = null
    var comHand: TextView? = null
    var youHand: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_old)
        comMessage = findViewById(R.id.comMessage)
        resultMessage = findViewById(R.id.resultMessage)
        comHand = findViewById(R.id.comHandMessage)
        youHand = findViewById(R.id.youHandMessage)
        //クリックしたらonClick()へ
        findViewById<View>(R.id.button1).setOnClickListener(this)
        findViewById<View>(R.id.button2).setOnClickListener(this)
        findViewById<View>(R.id.button3).setOnClickListener(this)
    }

    //View.OnClickListener.onClick()をコピーして命令追加
    override fun onClick(view: View) {
        //コンピュータのおてて乱数
        val com = (Math.random() * 3).toInt() //0=ぐー 1=ちょき 2=ぱー
        //グーチョキパーのボタン
        if (view.id == R.id.button1) battle(0, com)
        else if (view.id == R.id.button2) battle(1, com)
        else if (view.id == R.id.button3) battle(2, com)
    }

    private fun battle(you: Int, com: Int) {
        comMessage!!.text = "じゃーんけーん…"
        comMessage!!.text = "ぽん！"
        //自分のおてて
        if (you == 0) youHand!!.text = "✊"
        else if (you == 1) youHand!!.text = "✌"
        else youHand!!.text = "✋"
        //コンピュータのおてて
        if (com == 0) comHand!!.text = "✊"
        else if (com == 1) comHand!!.text = "✌"
        else comHand!!.text = "✋"
        //勝敗判定
        if (you == com) {   //あいこ
            comMessage!!.text = "なかなかやるじゃない"
        } else if (you - com == -1 || you - com == 2) {    //勝ち
            win++
            comMessage!!.text = "くっ、この私が…"
        } else {   //you-com==-2||you-com==1   //負け
            lose++
            comMessage!!.text = "ま、当然の結果ね！"
        }
        resultMessage!!.text = win.toString() + "勝" + lose + "敗"
    }
}
*/