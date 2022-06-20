//
//  ViewController.m
//  TextHeightFixDemo
//
//  Created by Ang Li on 2022/5/23.
//

#import "ViewController.h"

@interface UILabel(dolphin)

- (void)ne_dolphin_setTextWithFont:(UIFont *)font text:(NSString *)text;

- (void)ne_dolphin_setTextWithFont:(UIFont *)font text:(NSString *)text lineHeight:(CGFloat)lineHeight;

@end

@implementation UILabel(dolphin)

- (void)ne_dolphin_setTextWithFont:(UIFont *)font text:(NSString *)text {
    [self ne_dolphin_setTextWithFont:font text:text lineHeight:roundf(font.lineHeight)];
}

- (void)ne_dolphin_setTextWithFont:(UIFont *)font text:(NSString *)text lineHeight:(CGFloat)lineHeight {
    NSMutableDictionary *attributesDic = [NSMutableDictionary new];
    NSMutableParagraphStyle *paragraphStyle = [NSMutableParagraphStyle new];
    
    //视觉稿行高
    paragraphStyle.minimumLineHeight = lineHeight;
    paragraphStyle.maximumLineHeight = lineHeight;
    
    [attributesDic setObject:paragraphStyle forKey:NSParagraphStyleAttributeName];
    [attributesDic setObject:font forKey:NSFontAttributeName];
    
    // 设置baselineOffset为:(视觉稿行高 - 系统字体行高) / 4
    CGFloat baselineOffset = (lineHeight - font.lineHeight) / 4;
    [attributesDic setObject:@(baselineOffset) forKey:NSBaselineOffsetAttributeName];
    
    // 处理设置attributedText前后的textAlignment变化
    NSTextAlignment textAlignment = self.textAlignment;
    // 设置文本 + 参数
    self.attributedText = [[NSAttributedString alloc] initWithString:text attributes:attributesDic];
    self.textAlignment = textAlignment;
}

@end

@interface ViewController ()

@property (weak, nonatomic) IBOutlet UILabel *label_1;
@property (weak, nonatomic) IBOutlet UILabel *label_2;
@property (weak, nonatomic) IBOutlet UILabel *label_3;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [self.label_1 ne_dolphin_setTextWithFont:[UIFont systemFontOfSize:7.f] text:@"ggyy多行14号字" lineHeight:8.f];
    [self.label_2 ne_dolphin_setTextWithFont:[UIFont systemFontOfSize:11.f] text:@"ggyy多行14号字" lineHeight:13.f];
    [self.label_3 ne_dolphin_setTextWithFont:[UIFont systemFontOfSize:12.f] text:@"ggyy多行14号字" lineHeight:14.f];
//    self.label_3.font = [UIFont systemFontOfSize:12.f];
//    self.label_3.text = @"ggyy这是单行12号字";
    for (int i = 7; i <= 75; i++) {
        UIFont *font = [UIFont fontWithName:@"PingFangSC-Regular" size:(CGFloat)i];
        NSLog(@"FontSize：%d，Lineheight：%f，Rate：%f", i, font.lineHeight, font.lineHeight / i);
    }
}

@end
