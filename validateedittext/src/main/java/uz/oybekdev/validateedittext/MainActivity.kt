package uz.oybekdev.validateedittext

import android.app.AlertDialog
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import uz.oybekdev.validateedittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()
        passwordFocusListener()
        phoneFocusListener()

        binding.submitButton.setOnClickListener { submitForm() }
    }

    private fun submitForm()
    {
        binding.email.helperText = validEmail()
        binding.password.helperText = validPassword()
        binding.phone.helperText = validPhone()


        val validEmail = binding.email.helperText == null
        val validPassword = binding.password.helperText == null
        val validPhone = binding.phone.helperText == null

        if(validEmail && validPassword && validPhone)
            resetForm()
        else
            invalidForm()
    }
    private fun invalidForm()
    {
        var message = ""
        if(binding.email.helperText != null)
            message += "\n\nEmail: "+ binding.email.helperText
        if(binding.password.helperText != null)
            message += "\n\nPassword: "+ binding.password.helperText
        if(binding.phone.helperText != null)
            message += "\n\nPhone: "+ binding.phone.helperText

        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("Okay"){_,_ ->
                //do nothing
            }
            .show()
    }

    private fun resetForm()
    {
        var message = "Email: "+ binding.emailEditText.text
            message = "\nPassword: "+ binding.passwordEditText.text
            message = "\nPhone: "+ binding.phoneEditText.text
        AlertDialog.Builder(this)
            .setTitle("Form Submitted")
            .setMessage(message)
            .setPositiveButton("Okay"){_,_ ->
                binding.emailEditText.text = null
                binding.passwordEditText.text = null
                binding.phoneEditText.text = null

                binding.email.helperText = getString(R.string.Required)
                binding.password.helperText = getString(R.string.Required)
                binding.phone.helperText = getString(R.string.Required)
            }
            .show()
    }

    private fun emailFocusListener() {
        binding.emailEditText.setOnFocusChangeListener{_, focused ->
            if(!focused)
            {
                binding.email.helperText = validEmail()
            }
        }

    }

    private fun validEmail(): String?
    {
        val email = binding.emailEditText.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            return "Invalid Email Address"
        }
        return  null
    }

    private fun passwordFocusListener() {
        binding.passwordEditText.setOnFocusChangeListener{_, focused ->
            if(!focused)
            {
                binding.password.helperText = validPassword()
            }
        }

    }

    private fun validPassword(): String?
    {
        val password = binding.passwordEditText.text.toString()
        if (password.length < 0)
        {
            return "Minimum 8 Character Password"
        }
        if(!password.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 Upper-case Character"
        }
        if(!password.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 Lower-case Character"
        }
        if(!password.matches("@#\$%^&+=].*".toRegex()))
        {
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }
        return  null

    }

    private fun phoneFocusListener() {
        binding.phoneEditText.setOnFocusChangeListener{_, focused ->
            if(!focused)
            {
                binding.phone.helperText = validPhone()
            }
        }

    }

    private fun validPhone(): String?
    {
        val phone = binding.phoneEditText.text.toString()
        if (phone.matches(".*[0-9].*".toRegex()))
        {
            return "Must be all Digits"
        }
        if (phone.length != 10)
        {
            return "Must be 10 Digits"
        }
        return  null
    }
}