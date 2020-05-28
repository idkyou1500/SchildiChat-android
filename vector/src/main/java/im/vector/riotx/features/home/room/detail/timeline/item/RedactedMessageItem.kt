/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotx.features.home.room.detail.timeline.item

import android.content.Context
import com.airbnb.epoxy.EpoxyModelClass
import im.vector.riotx.R
import im.vector.riotx.features.themes.BubbleThemeUtils

@EpoxyModelClass(layout = R.layout.item_timeline_event_base)
abstract class RedactedMessageItem : AbsMessageItem<RedactedMessageItem.Holder>() {

    override fun getViewType() = STUB_ID

    override fun shouldShowReactionAtBottom() = false

    class Holder : AbsMessageItem.Holder(STUB_ID)

    companion object {
        private const val STUB_ID = R.id.messageContentRedactedStub
    }

    override fun messageBubbleAllowed(context: Context): Boolean {
        return BubbleThemeUtils.getBubbleStyle(context) == BubbleThemeUtils.BUBBLE_STYLE_BOTH
    }
}
