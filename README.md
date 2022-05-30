# 设计使用指南
### 📐一个宗旨，让字高修复一点即可
详细内容[请点击这里](https://github.com/SimoXiao/LineHeight-Fix-iOS-Android/releases/tag/Sketch-LineHeight-Auto-Fix-V2.1)



# 技术使用指南

### 🔨一个宗旨，让字高所见即所写（完整Demo按各端查阅：👆🏻👆🏻 ）    
具体 [Demo效果图](https://user-images.githubusercontent.com/19188214/170270296-4fc8bb93-6970-4a91-a87c-14b2f85efb81.png)

### iOS端，在描述iOS文本框时请引用如下UI Label代码：

```objectivec
#import <NEUIKit/UILabel+NEDolphinText.h>
UILabel *label = [UILabel new];
// 设置字号为12
UIFont *font = [UIFont fontWithName:@"PingFangSC-Regular" size:12.f]
// 设置字体、文字内容、视觉要求行高
[label ne_dolphin_setTextWithFont:font text:@"测试文案" lineHeight:14];
```

### Android端，在描述Android文本框时请引用如下textview代码：

```jsx
方法1： 文本包装span修改字体属性 - 建议
android:includeFontPadding="false"
单行标准行高 // 内容 + 字号 + 字号单位
setText(warpStandardHeightSpan("ceshi", 12 , TypedValue.COMPLEX_UNIT_DIP))
多行指定行高 // 内容 + 设计稿指定1.5倍行高
setText(warpFixHeightSpan("ceshi" , 18))

方法2：自定义组件
<com.netease.cloudmusic.dolphin.core_dolphin_text.FixHeightTextView
    android:textSize="12dp"      // 设置字体大小
    app:fixContent="文本内容"   // 设置文本内容
    app:fixLineHeight="18dp"   // 设置行高 （仅多行文本需要）
 />
```

### React Native端，在描述React Native侧的文本框时请引用如下代码：

```tsx
{/*lineHeight即视觉稿行高 */}
<Text style={{ fontSize: 12, lineHeight: 14 }}>
       文本内容
 </Text>

```
# 项目成员

[zhouxianyu](https://github.com/zhouxianyu)、 [Suo](https://github.com/suoyuesmile)、 [Simo](https://github.com/SimoXiao)
