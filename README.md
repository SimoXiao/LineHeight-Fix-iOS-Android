## 「Fin字高修复神器」技术使用指南**

🔨一个宗旨，让设计标注所见即所写，完整demo示例可参考：https://github.com/SimoXiao/LineHeight-Fix-iOS-Android
---
### iOS端，在描述iOS文本框时请引用如下UI Label代码：

```objectivec
#import <NEUIKit/UILabel+NEDolphinText.h>
UILabel *label = [UILabel new];
// 设置字号为14
UIFont *font = [UIFont systemFontOfSize:14];
// 设置字体、文字内容、视觉要求行高
[label ne_dolphin_setTextWithFont:font text:@"测试文案" lineHeight:16];
```
---
### Android端，在描述Android文本框时请引用如下textview代码：

```jsx
方法1： 文本包装span修改字体属性 - 建议
android:includeFontPadding="false"
单行标准行高 // 内容 + 字号 + 字号单位
setText(warpStandardHeightSpan("ceshi", 15 , TypedValue.COMPLEX_UNIT_DIP))
多行指定行高 // 内容 + 指定行高
setText(warpFixHeightSpan("ceshi" , 300))

方法2：自定义组件
<com.netease.cloudmusic.core.dolphin.component.text.DolphinTextView
    android:textSize="14dp"      // 设置字体大小
    app:dolphinText="文本内容"   // 设置文本内容
    app:dolphinLineHeight="24dp"   // 设置行高 （仅多行文本需要）
 />
```
---
### React Native端，在描述React Native侧的文本框时请引用如下代码：

```tsx
{/*lineHeight即视觉稿行高 */}
<Text style={{ fontSize: 12, lineHeight: 14 }}>
       文本内容
 </Text>

```
