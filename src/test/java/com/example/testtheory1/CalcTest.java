package com.example.testtheory1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalcTest {
  static Calc calc = null;

  @BeforeAll
  static void テスト前処理() {
    calc = new Calc();
  }

  @Test
  void addテスト_正常(){
    assertEquals(calc.add(1, 3), 4);
    assertThat(calc.add(1, 3)).isEqualTo(4);
  }

  @Test
  void subテスト_正常(){
    assertThat(calc.sub(5, 1)).isEqualTo(4);
  }

  @Test
  void divテスト_正常(){
    assertThat(calc.div(10, 2)).isEqualTo(5);
  }

  @Test
  void divテスト_異常_0除算(){
    assertThatThrownBy(() -> {
      calc.div(10, 0);
    })
    .isInstanceOf(ArithmeticException.class)
    .hasMessageContaining("by zero");
  }

  @Test
  void multテスト_正常(){
    assertThat(calc.mult(4, 9)).isEqualTo(36);
  }

  @AfterAll
  static void テスト後処理() {
    calc = null;
  }
  
}
