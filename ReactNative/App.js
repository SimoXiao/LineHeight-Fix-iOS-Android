/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {
  Text,
  View,
} from 'react-native';

const App = () => {
  const TextComponent = (props) => {
    return (
      <Text
        {...props}
        style={{
          ...props.style,
          lineHeight: Math.round(
            props.style.fontSize * (props.multiple ? 1.5 : 1.193359),
          ),
        }}
      />
    );
  };
  return (
    <View
      style={{
        width: 359,
        paddingLeft: 4,
        paddingRight: 20,
      }}>
      <Text
        style={{
          marginTop: 56,
          marginBottom: 33,
          fontSize: 16,
          fontWeight: 500,
        }}>
        Demo示例：以下所有元素纵向间距均为10pt
      </Text>
      <View style={{ flexDirection: 'row', justifyContent: 'space-between' }}>
        <View>
          <View
            style={{ backgroundColor: '#FF3A3A', width: 131, height: 42 }}
          />
          <Text
            style={{ fontSize: 16, backgroundColor: '#FF3A3A', marginTop: 10 }}>
            这是单行16号字
          </Text>
          <Text
            multiple
            style={{
              fontSize: 14,
              backgroundColor: '#FF3A3A',
              marginTop: 10,
              width: 113,
            }}>
            这是多行14号字， 1.5倍行高
          </Text>
          <Text
            style={{ fontSize: 12, backgroundColor: '#FF3A3A', marginTop: 10 }}>
            这是单行12号字
          </Text>
          <View
            style={{
              backgroundColor: '#FF3A3A',
              width: 131,
              height: 42,
              marginTop: 10,
            }}
          />
          <Text
            style={{
              width: 131,
              textAlign: 'center',
              marginTop: 10,
              fontSize: 12,
              lineHeight: 19,
            }}>
            ❎未修复前
          </Text>
        </View>
        <View>
          <View
            style={{ backgroundColor: '#FF3A3A', width: 131, height: 42 }}
          />
          <TextComponent
            style={{ fontSize: 16, backgroundColor: '#FF3A3A', marginTop: 10 }}>
            这是单行16号字
          </TextComponent>
          <TextComponent
            multiple
            style={{
              fontSize: 14,
              backgroundColor: '#FF3A3A',
              marginTop: 10,
              width: 113,
            }}>
            这是多行14号字， 1.5倍行高
          </TextComponent>
          <TextComponent
            style={{ fontSize: 12, backgroundColor: '#FF3A3A', marginTop: 10 }}>
            这是单行12号字
          </TextComponent>
          <View
            style={{
              backgroundColor: '#FF3A3A',
              width: 131,
              height: 42,
              marginTop: 10,
            }}
          />
          <Text
            style={{
              width: 131,
              textAlign: 'center',
              marginTop: 10,
              fontSize: 12,
              lineHeight: 19,
            }}>
            ✅修复后
          </Text>
        </View>
      </View>
    </View>
  );
};

export default App;
