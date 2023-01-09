package com.food.ordering.system.domain.entity;

// 코드를 보면 어떤 클래스가 엔터티이고 어떤 클래스가 집합체인지 알 수 있다.
// 이것은 마커클래스가 된다.
public abstract class AggregateRoot<ID> extends BaseEntity<ID> {
}
