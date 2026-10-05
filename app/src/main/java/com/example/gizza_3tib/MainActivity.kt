package com.example.gizza_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gizza_3tib.databinding.ActivityMainBinding
import com.example.gizza_3tib.pertemuan5.LimaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
class MainActivity : AppCompatActivity() {

    // 1. Deklarasi variabel binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 2. Inisialisasi binding menggantikan setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Mengambil data dari Intent
        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")
        val umur = intent.getIntExtra("umur", 0)

        Log.v("Hasil", "umur $umur")

        // 5. Menampilkan data ke TextView
        binding.txtUsername.text = user
        binding.txtPassword.text = pass

        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(
                binding.root,
                "Item dihapus",
                Snackbar.LENGTH_LONG
            )
                .setAction("BATAL") {
                    // kembalikan item
                }
                .show()
        }

        binding.btnAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage(
                    "Data yang dihapus tidak " +
                            "bisa dikembalikan."
                )
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }

        binding.btnKembali.setOnClickListener {
            finish()
        }

        binding.btnToLima.setOnClickListener {
            val intent = Intent(this@MainActivity, LimaActivity::class.java)
            startActivity(intent)
        }
    }
}