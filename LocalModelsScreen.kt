package io.github.nanomuse.localai

import android.content.Context
import java.io.File

data class LocalModelSpec(val id: String, val name: String, val url: String, val sizeGb: Double, val minRamGb: Int)

object LocalModels {
  val catalogue = listOf(
    LocalModelSpec("gemma-2-2b-abliterated", "Gemma 2 2B Abliterated", "https://huggingface.co/bartowski/gemma-2-2b-it-abliterated-GGUF/resolve/main/gemma-2-2b-it-abliterated-Q4_K_M.gguf", 1.6, 4),
    LocalModelSpec("phi-3-5-mini", "Phi-3.5 Mini 3.8B", "https://huggingface.co/bartowski/Phi-3.5-mini-instruct-GGUF/resolve/main/Phi-3.5-mini-instruct-Q4_K_M.gguf", 2.2, 4),
    LocalModelSpec("dolphin-llama3-8b", "Dolphin 2.9 Llama 3 8B", "https://huggingface.co/bartowski/dolphin-2.9-llama3-8b-GGUF/resolve/main/dolphin-2.9-llama3-8b-Q4_K_M.gguf", 4.9, 8),
    LocalModelSpec("gemma-4-heretic", "Gemma 4 E4B Heretic", "https://huggingface.co/llmfan46/gemma-4-E4B-it-ultra-uncensored-heretic-GGUF/resolve/main/gemma-4-E4B-it-ultra-uncensored-heretic-Q4_K_M.gguf", 5.34, 8)
  )
  fun directory(context: Context) = File(context.filesDir, "local-models").also { it.mkdirs() }
}
