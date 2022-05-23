//
//  ViewController.m
//  TextHeightFixDemo
//
//  Created by Ang Li on 2022/5/23.
//

#import "ViewController.h"

@interface UILabel(dolphin)

- (void)ne_dolphin_setTextWithFont:(UIFont *)font text:(NSString *)text lineHeight:(CGFloat)lineHeight;

@end

@implementation UILabel(dolphin)

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
    
    [self.label_1 ne_dolphin_setTextWithFont:[UIFont fontWithName:@"PingFangSC-Regular" size:16.f] text:@"这单行16号字" lineHeight:19.f];
    [self.label_2 ne_dolphin_setTextWithFont:[UIFont fontWithName:@"PingFangSC-Regular" size:14.f] text:@"这是多行14号字，\n1.5倍行高" lineHeight:21.f];
    [self.label_3 ne_dolphin_setTextWithFont:[UIFont fontWithName:@"PingFangSC-Regular" size:12.f] text:@"这是单行12号字" lineHeight:14.f];
}

@end
