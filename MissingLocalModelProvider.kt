package io.github.nanomuse.localai

import com.openminis.app.data.model.AgentToolDefinition
import com.openminis.app.data.model.LLMError
import com.openminis.app.data.model.LLMMessage
import com.openminis.app.data.model.LLMModel
import com.openminis.app.data.model.LLMResponse
import com.openminis.app.data.model.LLMStreamChunk
import com.openminis.app.data.model.ThinkingLevel
import com.openminis.app.provider.LLMProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/** Avoids an app crash when a chat still points at a removed GGUF file. */
class MissingLocalModelProvider(override var model: LLMModel) : LLMProvider {
  override val name = "Local GGUF"
  private fun unavailable(): Nothing = throw LLMError.ProviderError(
    "This local model file is not installed. Open Settings → Models → Local models and download or import it again."
  )
  override suspend fun sendMessageClamped(messages: List<LLMMessage>, systemPrompt: String?, maxTokens: Int, temperature: Double?, imageParts: List<LLMMessage.ImagePart>, tools: List<AgentToolDefinition>, thinkingLevel: ThinkingLevel): LLMResponse = unavailable()
  override fun streamMessageClamped(messages: List<LLMMessage>, systemPrompt: String?, maxTokens: Int, temperature: Double?, imageParts: List<LLMMessage.ImagePart>, tools: List<AgentToolDefinition>, thinkingLevel: ThinkingLevel): Flow<LLMStreamChunk> = flow { unavailable() }
}
